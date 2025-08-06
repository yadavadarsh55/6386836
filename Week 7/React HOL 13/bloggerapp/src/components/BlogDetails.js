import React from "react";

const blogs = [
  {
    title: "React Patterns",
    author: "Dan Abramov",
    description: "A guide to React design patterns.",
  },
  {
    title: "JavaScript Tips",
    author: "Kyle Simpson",
    description: "Best practices for modern JS.",
  },
  {
    title: "CSS Tricks",
    author: "Chris Coyier",
    description: "Handy CSS techniques and tips.",
  },
];

function BlogDetails({ show }) {
  // Conditional rendering: using if statement
  if (!show) return null;
  return (
    <div>
      <h2>Blog Details</h2>
      {blogs.map((blog, idx) => (
        <div key={idx} style={{ marginBottom: "1rem" }}>
          <div>
            <b>{blog.title}</b>
          </div>
          <div>Author: {blog.author}</div>
          <div>{blog.description}</div>
        </div>
      ))}
    </div>
  );
}

export default BlogDetails;
