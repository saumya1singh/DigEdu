package com.mind.simplelogin;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.github.sundeepk.compactcalendarview.CompactCalendarView;
import com.github.sundeepk.compactcalendarview.domain.Event;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class CalendarActivity extends AppCompatActivity {

    CompactCalendarView calender;
    private SimpleDateFormat dateFormat=new SimpleDateFormat("MMMM-yyyy", Locale.getDefault());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calendar);

        final ActionBar actionBar=getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(false);
        actionBar.setTitle(null);

        calender=findViewById(R.id.compactcalendar_view);
        calender.setUseThreeLetterAbbreviation(true);

        //set an event for the teachers and professional day

        Event ev1=new Event(Color.RED, 1477054800000L, "Teachers' professional day");
        calender.addEvent(ev1);

        calender.setListener(new CompactCalendarView.CompactCalendarViewListener() {
            @Override
            public void onDayClick(Date dateClicked) {
                Context context =getApplicationContext();

                if (dateClicked.toString().compareTo("Sun Oct 21 09:00:00 AST 2019")==0){
                    Toast.makeText(context,"Teacher's professional day", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(context,"No Events planned for this day", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onMonthScroll(Date firstDayOfNewMonth) {
                actionBar.setTitle(dateFormat.format(firstDayOfNewMonth));

            }
        });

    }
}
