## Blog Platform

## Overview
This project is a RESTful API for a Blog Platform, developed using Spring Boot and PostgreSQL. It provides endpoints to manage User, Post, Category and Tag entities. The application supports full CRUD operations and adheres the best practices, 
including the use of DTOs to control data exposure.

## Features
- Post Management: Create, edit, delete, and publish blog posts.
- Categories and Tags: Organize posts using categories and tags.
- Reading Time Estimation: Displays estimated reading time for each post.
- Draft Management: Save drafts and continue editing later.

## Entities
### Post
A blog post is a piece of written content that includes a title, body text, optional images, tags, and a publication date. Posts can be either drafts or published articles.

### Category
A category is a broad classification used to organize blog posts into main themes or topics (e.g., "Technology", "Travel", "Personal Development"). Each post belongs to a single category.

### Tag
A tag is a specific keyword or phrase that describes the content of a post in more detail than categories. Unlike categories, tags are more granular and flexible (e.g., "Python", "Machine Learning", "Book Review", "Venice"). A single post can have multiple tags to improve searchability and content discovery.

## API Endpoints
### Posts Endpoints
- `GET /api/v1/posts` - Retrieve published posts.  
- `POST /api/v1/posts` - Create a new post (draft or published).  
- `GET /api/v1/posts/{id}` - Fetch specific post details.  
- `PUT /api/v1/posts/{id}` - Update a post.  
- `DELETE /api/v1/posts/{id}` - Remove a post.  
- `GET /api/v1/posts/drafts` - Retrieve drafts (authenticated users only).  

### Categories Endpoints
- `GET /api/v1/categories` - List all categories with post counts.  
- `POST /api/v1/categories` - Create a new category.  
- `DELETE /api/v1/categories/{id}` - Remove an unused category.  

### Tags Endpoints
- `GET /api/v1/tags` - Retrieve all tags with usage stats.  
- `POST /api/v1/tags` - Create new tags.  
- `DELETE /api/v1/tags/{id}` - Remove an unused tag.  

## Technologies Used
- Java 21
- Spring Boot 3
  - Spring Data JPA
  - Spring Web
  - Spring Security with JWT
- PostgreSQL for database
- Maven for dependency management
