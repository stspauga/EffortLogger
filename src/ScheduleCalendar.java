package src;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;
import javafx.geometry.Insets;
import javafx.geometry.Pos;

class ScheduleCalendar extends BorderPane {
	private Calendar currentMonth;
	
	public ScheduleCalendar() {
		currentMonth = new GregorianCalendar();
		currentMonth.set(Calendar.DAY_OF_MONTH, 1);
		
		setCalendar();				//set up the calendar based on the month
	}
	
	private void setCalendar() {
		setHeader();
		setBody();
		setFooter();
	}
	
	private void setHeader() {
		String yearString = String.valueOf(currentMonth.get(Calendar.YEAR));
		String monthString = getMonthName(currentMonth.get(Calendar.MONTH));
		Text headerText = new Text(monthString + ", " + yearString);
		
		setTop(headerText);
		setMargin(headerText, new Insets(15));
		setAlignment(headerText, Pos.CENTER);
		
	}
		
	private void setBody() {
		GridPane gpBody = new GridPane();
		gpBody.setHgap(15);
        gpBody.setVgap(15);
        gpBody.setAlignment(Pos.CENTER);
        gpBody.setMinHeight(350);
		
		//set up the days of the week
        for (int d = 1; d <= 7; d++) {
        	Text dayName = new Text(getDayName(d));
        	gpBody.add(dayName, d-1, 0);
        }
        
        //set up the days in each month
        int currentDate = currentMonth.get(Calendar.DAY_OF_MONTH);
        int daysForMonth = currentMonth.getActualMaximum(Calendar.DAY_OF_MONTH);
        int daysForWeek = currentMonth.get(Calendar.DAY_OF_WEEK);
        int count = 1;
        for (int ii = currentDate; ii <= daysForMonth; ii++ ) {
        	if (daysForWeek == 8) {
        		daysForWeek = 1;
        		count++;
        	}
        	
        	Text dayText = new Text(String.valueOf(currentDate));
        	gpBody.add(dayText, daysForWeek - 1, count);
        	currentDate++;
        	daysForWeek++;
        }
        
        //set up days in previous month
        currentMonth.set(Calendar.DAY_OF_MONTH, currentMonth.getActualMaximum(Calendar.DAY_OF_MONTH));
        daysForWeek = currentMonth.get(Calendar.DAY_OF_WEEK);
        if (daysForWeek != 7) {
        	int day = 1;
        	for (int i = daysForWeek; i < 7; i++) {
        		Text dateText = new Text(String.valueOf(day));
        		dateText.setFill(Color.LIGHTBLUE);
        		gpBody.add(dateText, i, count);
        		day++;
        	}
        }
        
        setCenter(gpBody);
        setMargin(gpBody, new Insets(25));
		
	}
	
	//set up functional buttons to navigate between months
	private void setFooter() {
		Button prevButton = new Button("<=");
		Button nextButton = new Button("=>");
		
		prevButton.setOnAction(e -> previousPage());
		nextButton.setOnAction(e -> nextPage());
		
		HBox hbFooter = new HBox(12);
		hbFooter.getChildren().addAll(prevButton, nextButton);
		hbFooter.setAlignment(Pos.CENTER);
		setBottom(hbFooter);
		setMargin(hbFooter, new Insets(18));
		
		
	}
	
	private void previousPage() {
		getChildren().clear();
		currentMonth = getPrevMonth(currentMonth);
		setCalendar();
	}
	
	private void nextPage() {
		getChildren().clear();
		currentMonth = getNextMonth(currentMonth);
		setCalendar();
	}
	
	//set up to display the calendar of the previous month
	private GregorianCalendar getPrevMonth(Calendar calendar) {
		int cMonth = calendar.get(Calendar.MONTH);
		int prevMonth = cMonth == 0 ? 11 : cMonth - 1;
		int prevYear = cMonth == 0 ? calendar.get(Calendar.YEAR) - 1 : calendar.get(Calendar.YEAR);
		return new GregorianCalendar(prevYear, prevMonth, 1);
	}
	
	//set up to display the calendar of the next month
	private GregorianCalendar getNextMonth(Calendar calendar) {
		int cMonth = calendar.get(Calendar.MONTH);
		int nextMonth = cMonth == 11 ? 0 : cMonth + 1;
		int nextYear = cMonth == 11 ? calendar.get(Calendar.YEAR) + 1 : calendar.get(Calendar.YEAR);
		return new GregorianCalendar(nextYear, nextMonth, 1);
	}
	
	private String getDayName(int name) {
		StringBuilder sb = new StringBuilder();
		switch(name) {
		case 1:
	         sb.append("Sunday");
	         break;
	      case 2:
	         sb.append("Monday");
	         break;
	      case 3:
	         sb.append("Tuesday");
	         break;
	      case 4:
	         sb.append("Wednesday");
	         break;
	      case 5:
	         sb.append("Thursday");
	         break;
	      case 6:
	         sb.append("Friday");
	         break;
	      case 7:
	         sb.append("Saturday");
	      }
	      return sb.toString();
	   }
	
	private String getMonthName(int name) {
		String[] monthName = {"January", "February", "March", "April", "May", "June", "July", "August", "September",
	            "October", "November", "December"};
		return monthName[name];

	}
	
}
