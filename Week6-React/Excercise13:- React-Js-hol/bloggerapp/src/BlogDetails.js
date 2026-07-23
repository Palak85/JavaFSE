import React from 'react';

// Extracted BlogItem component representing a list item with keys
function BlogItem({ blog }) {
  return (
    <div style={{ padding: '15px', borderBottom: '1px solid #eee', textAlign: 'left' }}>
      <h4 style={{ margin: '0 0 5px 0', color: '#e67e22' }}>{blog.title}</h4>
      <p style={{ margin: '0 0 5px 0', fontSize: '13px', color: '#888' }}>
        Published by <strong>{blog.author}</strong> on {blog.date}
      </p>
      <p style={{ margin: 0, fontSize: '13px', color: '#444' }}>{blog.summary}</p>
    </div>
  );
}

const BlogDetails = ({ blogs }) => {
  return (
    <div style={{ background: '#fff', padding: '20px', borderRadius: '8px', boxShadow: '0 4px 8px rgba(0,0,0,0.05)' }}>
      <h3 style={{ margin: '0 0 15px 0', color: '#333' }}>Recent Blog Posts</h3>
      {blogs.length === 0 ? (
        <p>No blogs published yet.</p>
      ) : (
        <div>
          {blogs.map(blog => (
            // Passing the unique key prop to the extracted component
            <BlogItem key={blog.id} blog={blog} />
          ))}
        </div>
      )}
    </div>
  );
};

export default BlogDetails;
