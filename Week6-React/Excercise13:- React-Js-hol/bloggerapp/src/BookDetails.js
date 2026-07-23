import React from 'react';

// Extracted BookItem component representing a list item with keys
function BookItem({ book }) {
  return (
    <div style={{ padding: '15px', borderBottom: '1px solid #eee', textAlign: 'left' }}>
      <h4 style={{ margin: '0 0 5px 0', color: '#0056b3' }}>{book.title}</h4>
      <p style={{ margin: '0 0 5px 0', fontSize: '14px', color: '#666' }}>
        <strong>Author:</strong> {book.author}
      </p>
      <p style={{ margin: 0, fontSize: '13px', color: '#444' }}>{book.description}</p>
    </div>
  );
}

const BookDetails = ({ books }) => {
  return (
    <div style={{ background: '#fff', padding: '20px', borderRadius: '8px', boxShadow: '0 4px 8px rgba(0,0,0,0.05)' }}>
      <h3 style={{ margin: '0 0 15px 0', color: '#333' }}>Book Catalog</h3>
      {books.length === 0 ? (
        <p>No books available.</p>
      ) : (
        <div>
          {books.map(book => (
            // Passing the unique key prop to the extracted component
            <BookItem key={book.id} book={book} />
          ))}
        </div>
      )}
    </div>
  );
};

export default BookDetails;
