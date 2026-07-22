import React, { Component } from 'react';
import Post from './Post';

class Posts extends Component {
  constructor(props) {
    super(props);
    this.state = {
      posts: [],
      error: null
    };
  }

  loadPosts() {
    fetch('https://jsonplaceholder.typicode.com/posts')
      .then(response => {
        if (!response.ok) {
          throw new Error('Network response was not ok');
        }
        return response.json();
      })
      .then(data => {
        // Map the parsed JSON list to a list of Post instances
        const postList = data.map(item => new Post(item.id, item.title, item.body));
        this.setState({ posts: postList });
      })
      .catch(error => {
        this.setState({ error: error });
        throw error;
      });
  }

  componentDidMount() {
    this.loadPosts();
  }

  componentDidCatch(error, errorInfo) {
    alert("An error occurred: " + error.toString());
  }

  render() {
    const { posts, error } = this.state;
    if (error) {
      return (
        <div style={{ color: 'red', padding: '20px' }}>
          <h2>Failed to load posts.</h2>
        </div>
      );
    }
    return (
      <div className="posts-container" style={{ padding: '20px', fontFamily: 'Arial, sans-serif' }}>
        <h1 style={{ borderBottom: '2px solid #333', paddingBottom: '10px' }}>Blog Posts</h1>
        {posts.map(post => (
          <div key={post.id} className="post-item" style={{ borderBottom: '1px solid #ccc', margin: '20px 0', paddingBottom: '10px' }}>
            <h3>{post.title}</h3>
            <p>{post.body}</p>
          </div>
        ))}
      </div>
    );
  }
}

export default Posts;
