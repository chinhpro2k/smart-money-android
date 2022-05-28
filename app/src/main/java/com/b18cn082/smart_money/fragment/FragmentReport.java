package com.b18cn082.smart_money.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.b18cn082.smart_money.R;
import com.b18cn082.smart_money.model.UserExpenseStatistic;
import com.b18cn082.smart_money.util.APIUtils;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragmentReport extends Fragment {
    private BarChart barChart;
    private TextView textViewMonthlyExpenseStat;
    private SwipeRefreshLayout swipeRefreshLayout;
    private Spinner spinnerYear;
    private int year;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_report,container,false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        barChart = view.findViewById(R.id.barChart);
        textViewMonthlyExpenseStat = view.findViewById(R.id.textViewMonthlyStatistic);
        swipeRefreshLayout = view.findViewById(R.id.swipeLayout);
        spinnerYear = view.findViewById(R.id.spinnerYear);

        year = Calendar.getInstance().get(Calendar.YEAR);

        // Gia su 2019 la nam he thong start up
        List<Integer> years = new ArrayList<>();
        for (int i = year; i >= 2019; i--) {
            years.add(i);
        }
        spinnerYear.setAdapter(new ArrayAdapter(getActivity(), R.layout.item_text_spinner, years));



    }

    private void callAPIGetMonthlyStats(int year) {
        APIUtils.getApiServiceInterface().getMonthlyExpenseStatisticsOfUser(year)
                .enqueue(new Callback<List<UserExpenseStatistic>>() {
            @Override
            public void onResponse(Call<List<UserExpenseStatistic>> call, Response<List<UserExpenseStatistic>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<UserExpenseStatistic> statisticList = response.body();

                    updateBarChartUI(statisticList, year);
                }
            }

            @Override
            public void onFailure(Call<List<UserExpenseStatistic>> call, Throwable t) {

            }
        });
    }

    private void updateBarChartUI(List<UserExpenseStatistic> expenseStatisticList, int year) {
        textViewMonthlyExpenseStat.setText("User's Monthly Expense " + year);
        List<BarEntry> barEntries = new ArrayList<>();

        for (int i = 0; i < 12; i++) {
            UserExpenseStatistic userExpenseStatistic = expenseStatisticList.get(i);
            BarEntry barEntry = new BarEntry(i, userExpenseStatistic.getExpenseSumOfMonth());
            barEntries.add(barEntry);
        }


        BarDataSet barDataSet = new BarDataSet(barEntries, "User Expenses (Unit $)");
        BarData barData = new BarData(barDataSet);
        barData.setValueTextSize(15f);
        barDataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        barChart.setData(new BarData(barDataSet));
        barChart.animateY(1000);
        barChart.getDescription().setText("User Expenses Of " + year);
        barChart.getDescription().setTextColor(R.color.white);
        barChart.getDescription().setTextSize(16);
        final ArrayList<String> xAxisLabel = new ArrayList<>();
        xAxisLabel.add("Jan");
        xAxisLabel.add("Feb");
        xAxisLabel.add("Mar");
        xAxisLabel.add("April");
        xAxisLabel.add("May");
        xAxisLabel.add("June");
        xAxisLabel.add("July");
        xAxisLabel.add("Aug");
        xAxisLabel.add("Sep");
        xAxisLabel.add("Oct");
        xAxisLabel.add("Nov");
        xAxisLabel.add("Dec");

        barChart.getXAxis().setValueFormatter(new IndexAxisValueFormatter(xAxisLabel));
        barChart.getXAxis().setLabelCount(xAxisLabel.size());

        YAxis yAxisleft = barChart.getAxisLeft();
        yAxisleft.setValueFormatter(new ValueFormatter() {
            @Override
            public String getFormattedValue(float value) {

                return value + " $";
            }
        });

        YAxis yAxisright = barChart.getAxisRight();
        yAxisright.setValueFormatter(new ValueFormatter() {
            @Override
            public String getFormattedValue(float value) {

                return "";
            }
        });
        barChart.invalidate();
    }
}
