import React from "react";

const books = [
  { id: 1, name: "Learning React", price: "$30" },
  { id: 2, name: "JavaScript: The Good Parts", price: "$25" },
  { id: 3, name: "CSS Secrets", price: "$20" },
];

function BookDetails({ show }) {
  // Conditional rendering: using ternary operator
  return show ? (
    <div>
      <h2>Book Details</h2>
      {books.map((book) => (
        <div key={book.id} style={{ marginBottom: "1rem" }}>
          <div>Book ID: {book.id}</div>
          <div>Book Name: {book.name}</div>
          <div>Book Price: {book.price}</div>
        </div>
      ))}
    </div>
  ) : null;
}

export default BookDetails;
