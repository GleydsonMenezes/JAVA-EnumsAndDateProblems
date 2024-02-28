package entities;

import java.util.Date;

public class HourContract {

		private Date date;
		private Double ValuePerHour;
		private Integer Hours;
		
		public HourContract() {
			
		}

		public HourContract(Date date, Double valuePerHour, Integer hours) {
			this.date = date;
			ValuePerHour = valuePerHour;
			Hours = hours;
		}

		public Date getDate() {
			return date;
		}

		public void setDate(Date date) {
			this.date = date;
		}

		public Double getValuePerHour() {
			return ValuePerHour;
		}

		public void setValuePerHour(Double valuePerHour) {
			ValuePerHour = valuePerHour;
		}

		public Integer getHours() {
			return Hours;
		}

		public void setHours(Integer hours) {
			Hours = hours;
		}
		
		public Double totalValue() {
			return ValuePerHour * Hours;
		}
	
}
