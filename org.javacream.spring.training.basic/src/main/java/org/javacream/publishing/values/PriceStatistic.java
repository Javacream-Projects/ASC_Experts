package org.javacream.publishing.values;

public class PriceStatistic {

	private double totalPrice;
	private double maxPrice;
	private double minPrice;
	private double averagePrice;
	public PriceStatistic() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "PriceStatistic [totalPrice=" + totalPrice + ", maxPrice="
				+ maxPrice + ", minPrice=" + minPrice + ", averagePrice="
				+ averagePrice + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(averagePrice);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(maxPrice);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(minPrice);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(totalPrice);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PriceStatistic other = (PriceStatistic) obj;
		if (Double.doubleToLongBits(averagePrice) != Double
				.doubleToLongBits(other.averagePrice))
			return false;
		if (Double.doubleToLongBits(maxPrice) != Double
				.doubleToLongBits(other.maxPrice))
			return false;
		if (Double.doubleToLongBits(minPrice) != Double
				.doubleToLongBits(other.minPrice))
			return false;
		if (Double.doubleToLongBits(totalPrice) != Double
				.doubleToLongBits(other.totalPrice))
			return false;
		return true;
	}
	public PriceStatistic(double totalPrice, double maxPrice, double minPrice,
			double averagePrice) {
		super();
		this.totalPrice = totalPrice;
		this.maxPrice = maxPrice;
		this.minPrice = minPrice;
		this.averagePrice = averagePrice;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public double getMaxPrice() {
		return maxPrice;
	}
	public double getMinPrice() {
		return minPrice;
	}
	public double getAveragePrice() {
		return averagePrice;
	}
	
}
