package com.vti.entity;

public class Cpu {
	private float price;
	public Processor processor;
	public Ram ram;
	
	/**
	 * @param price
	 */
	public Cpu(float price) {
		super();
		this.price = price;
//		processor = new Processor(4, "Intel");
//		ram = new Ram(2.5f, "Fpt");
	}

	public class Processor {
		private int coreAmount;
		private String manufacturer;
		
		/**
		 * @param coreAmount
		 * @param manufacturer
		 */
		public Processor(int coreAmount, String manufacturer) {
			super();
			this.coreAmount = coreAmount;
			this.manufacturer = manufacturer;
		}

		public float getCache() {
			return 4.3f;
		}
	}
	
	public class Ram {
		private float memory;
		private String manufacturer;
		
		/**
		 * @param memory
		 * @param manufacturer
		 */
		public Ram(float memory, String manufacturer) {
			super();
			this.memory = memory;
			this.manufacturer = manufacturer;
		}

		public float getClockSpeed() { 
			return 5.5f;
		}
	}
}
