<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="styleAddInfo.css" >
<title>Electricity accounting</title>
</head>
<body>
	<h2>Add information for the month</h2>
	<form method="post" action="add-month">
	<div class="combobox">
	<div class="month">
		<label for="month">Months:</label>
		<select name="month" id="month">
			<option value="January">January</option>
			<option value="February">February</option>
			<option value="March">March</option>
			<option value="April">April</option>
			<option value="May">May</option>
			<option value="June">June</option>
			<option value="July">July</option>
			<option value="August">August</option>
			<option value="September">September</option>
			<option value="October">October</option>
			<option value="November">November</option>
			<option value="December">December</option>
		</select>
	</div>
	
	<div class="year">
		<label for="year">Year:</label>
		<select name="year" id="year">
			<option value="2017">2017</option>
			<option value="2018">2018</option>
			<option value="2019">2019</option>
		</select>
	</div>
</div>
	
	<div class="prev_result" >
		<label for="prev_result" >Result of previous counter:</label>
		<input id="prev_result" type="text" name="previousResult">
	</div>
	
	<div class="curr_result">
		<label for="curr_result" >Result of current counter:</label> 
		<input id="curr_result" type="text" name="currentResult">
	</div>
	
	<div class="price">
		<label for="price">Price:</label>
		<input id="price" type="text" name="price">
	</div>
	
	<input type="submit" id="submit"></input>
	</form>
	
	<div>
		<p>Current month: ${month} ${year} ${previousResult} ${currentResult} ${energyPerMonth} ${price} ${cost} </p>
		<a href="infoForPeriod.jsp">Click here to show info for period</a>
	</div>
	
</body>
</html>