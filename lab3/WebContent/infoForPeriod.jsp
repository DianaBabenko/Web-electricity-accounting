<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="stylePeriodInfo.css">
<title>Info for period</title>
</head>
<body>
	<h2>Information for period</h2>

		<form method="get" action="period-data">
		<div class="combobox1">
			<div>	
				<label for="first_month">First month:</label>
				<select name="first_month" id="first_month">
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
			
			<div class="first_year">
				<label for="first_year">First year:</label>
				<select name="first_year" id="first_year">
					<option value="2017">2017</option>
					<option value="2018">2018</option>
					<option value="2019">2019</option>
				</select>
			</div>
		</div>
		<div class="combobox2">
			<div>
			<label for="last_month">Last month:</label>
				<select name="last_month" id="last_month">
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

			<div class="last_year">
				<label for="last_year">Last year:</label>
				<select name="last_year" id="last_year">
					<option value="2017">2017</option>
					<option value="2018">2018</option>
					<option value="2019">2019</option>
				</select>
			</div>
		</div>

		<input type="submit" id="submit"></input>
		</form>
		<div class="result">
			<div class="period_info">
				<h4>Period from ${firstMonth} ${firstYear} to ${lastMonth} ${lastYear} :</h4>
				<table>
					<tr>
						<th>Month</th>
						<th>Year</th>
						<th>Previous counter</th>
						<th>Current counter</th>
						<th>Used energy</th>
						<th>Price</th>
						<th>Cost</th>
					</tr>
					<c:forEach items="${dataForPeriod}" var="month">
					<tr>
						<td>${month.month}</td>
						<td>${month.year}</td>
						<td>${month.resultOfPreviousCounter}</td>
						<td>${month.resultOfCurrentCounter}</td>
						<td>${month.energyPerMonth}</td>
						<td>${month.price}</td>
						<td>${month.costPerMonth}</td>
					</tr>
					</c:forEach>
				</table>
			</div>

			<div class="calc">
				<p>Used energy: ${get_energy} Cost: ${get_cost}</p>
			</div>
		</div>

		<a href="index.jsp">Click here to add months</a>
	
</body>
</html>