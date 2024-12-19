package com.harimaulana.bookstore.model;

import jakarta.persistence.*;
	
	@Entity // Annotate class as entity
	public class Book {
		@Id // Annotate id as primary key
		@GeneratedValue(strategy = GenerationType.IDENTITY)// Auto-generate id
		// Day 0 topics: Primitive
		private Long id;
		private String title;
		private String author;
		private Double price;
		
		// Getter and Setter
		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}
		
		public String getTitle() {
			return title;
		}
		
		public void setTitle(String title) {
			this.title = title;
		}
		
		public String getAuthor() {
			return author;
		}
		
		public void setAuthor(String author) {
			this.author = author;
		}
		
		public Double getPrice() {
			return price;
		}
		
		public void setPrice(Double price) {
			this.price = price;
		}
	}

