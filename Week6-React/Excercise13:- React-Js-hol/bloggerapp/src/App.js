import React, { useState } from 'react';
import BookDetails from './BookDetails';
import BlogDetails from './BlogDetails';
import CourseDetails from './CourseDetails';
import './App.css';

function App() {
  const [activeTab, setActiveTab] = useState('books');
  const [showStats, setShowStats] = useState(true);
  const [userRole, setUserRole] = useState('guest'); // guest, admin
  const [bannerClosed, setBannerClosed] = useState(false);

  // Mock data lists
  const booksData = [
    { id: 101, title: "Clean Code", author: "Robert C. Martin", description: "A handbook of agile software craftsmanship." },
    { id: 102, title: "The Pragmatic Programmer", author: "Andy Hunt", description: "Your journey to mastery." }
  ];

  const blogsData = [
    { id: 201, title: "Mastering React Lifecycle Hooks", author: "Palak Singh", date: "July 22, 2026", summary: "Learn standard mount and catch event methods in React." },
    { id: 202, title: "Introduction to ES6 spread operators", author: "Jane Doe", date: "June 15, 2026", summary: "Easy arrays and objects merging walkthrough." }
  ];

  const coursesData = [
    { id: 301, title: "Java Full Stack Engineering", instructor: "Academy Mentor", duration: "12 Weeks", description: "Spring Boot, Maven, REST APIs, and React JS." },
    { id: 302, title: "AWS Cloud Practitioner Mastery", instructor: "Cloud Specialist", duration: "6 Weeks", description: "Global infrastructure, IAM, EC2, and VPC configurations." }
  ];

  // 1. Conditional Rendering using Switch-Case inside a helper function
  const renderContent = () => {
    switch(activeTab) {
      case 'books':
        return <BookDetails books={booksData} />;
      case 'blogs':
        return <BlogDetails blogs={blogsData} />;
      case 'courses':
        return <CourseDetails courses={coursesData} />;
      default:
        return null;
    }
  };

  // 2. Conditional Rendering using Element Variables
  let roleNotification;
  if (userRole === 'admin') {
    roleNotification = (
      <div style={{ padding: '10px', background: '#d4edda', color: '#155724', borderRadius: '4px', margin: '10px 0', border: '1px solid #c3e6cb' }}>
        System Status: Admin Dashboard active. Full modification access.
      </div>
    );
  } else {
    roleNotification = (
      <div style={{ padding: '10px', background: '#e2e3e5', color: '#383d41', borderRadius: '4px', margin: '10px 0', border: '1px solid #d6d8db' }}>
        System Status: Guest Mode. View catalog items only.
      </div>
    );
  }

  return (
    <div className="App" style={{ fontFamily: 'Arial, sans-serif', padding: '30px', backgroundColor: '#f8f9fa', minHeight: '100vh' }}>
      <header style={{ maxWidth: '900px', margin: '0 auto', borderBottom: '2px solid #eee', paddingBottom: '20px' }}>
        <h1 style={{ color: '#2c3e50', textAlign: 'center' }}>Blogger Catalog Dashboard</h1>
        
        {/* Toggle Stats Header */}
        <div style={{ textAlign: 'center', margin: '15px 0' }}>
          <button 
            onClick={() => setShowStats(!showStats)}
            style={{ padding: '8px 16px', border: '1px solid #ccc', borderRadius: '4px', cursor: 'pointer', background: '#fff', marginRight: '10px' }}
          >
            {showStats ? 'Hide Overview Stats' : 'Show Overview Stats'}
          </button>
          
          <button 
            onClick={() => setUserRole(userRole === 'guest' ? 'admin' : 'guest')}
            style={{ padding: '8px 16px', border: '1px solid #ccc', borderRadius: '4px', cursor: 'pointer', background: '#fff' }}
          >
            Toggle Role (Current: {userRole})
          </button>
        </div>

        {/* 3. Conditional Rendering using Logical AND (&&) */}
        {showStats && (
          <div style={{ display: 'flex', justifyContent: 'space-around', background: '#e9ecef', padding: '15px', borderRadius: '6px', margin: '15px 0' }} id="stats-banner">
            <div><strong>Books:</strong> {booksData.length}</div>
            <div><strong>Blogs:</strong> {blogsData.length}</div>
            <div><strong>Courses:</strong> {coursesData.length}</div>
          </div>
        )}

        {/* Displaying our Element Variable */}
        {roleNotification}
      </header>

      <main style={{ maxWidth: '900px', margin: '20px auto', display: 'flex', gap: '20px' }}>
        {/* Navigation Sidebar */}
        <div style={{ flex: '1', display: 'flex', flexDirection: 'col', gap: '10px', background: '#fff', padding: '20px', borderRadius: '8px', boxShadow: '0 4px 8px rgba(0,0,0,0.05)', minWidth: '180px' }}>
          <h3 style={{ margin: '0 0 10px 0', fontSize: '16px', color: '#555' }}>Menu Options</h3>
          <button 
            onClick={() => setActiveTab('books')}
            style={{ 
              padding: '12px', 
              background: activeTab === 'books' ? '#007bff' : '#f8f9fa', 
              color: activeTab === 'books' ? '#fff' : '#333', 
              border: 'none', 
              borderRadius: '4px', 
              cursor: 'pointer',
              fontWeight: 'bold',
              textAlign: 'left',
              marginBottom: '8px',
              display: 'block',
              width: '100%'
            }}
          >
            Books
          </button>
          <button 
            onClick={() => setActiveTab('blogs')}
            style={{ 
              padding: '12px', 
              background: activeTab === 'blogs' ? '#007bff' : '#f8f9fa', 
              color: activeTab === 'blogs' ? '#fff' : '#333', 
              border: 'none', 
              borderRadius: '4px', 
              cursor: 'pointer',
              fontWeight: 'bold',
              textAlign: 'left',
              marginBottom: '8px',
              display: 'block',
              width: '100%'
            }}
          >
            Blogs
          </button>
          <button 
            onClick={() => setActiveTab('courses')}
            style={{ 
              padding: '12px', 
              background: activeTab === 'courses' ? '#007bff' : '#f8f9fa', 
              color: activeTab === 'courses' ? '#fff' : '#333', 
              border: 'none', 
              borderRadius: '4px', 
              cursor: 'pointer',
              fontWeight: 'bold',
              textAlign: 'left',
              display: 'block',
              width: '100%'
            }}
          >
            Courses
          </button>
        </div>

        {/* Content Panel Area */}
        <div style={{ flex: '3' }}>
          {/* 4. Conditional Rendering using Ternary Operator */}
          {!bannerClosed ? (
            <div style={{ padding: '12px', background: '#fff3cd', color: '#856404', borderRadius: '6px', marginBottom: '15px', display: 'flex', justifyContent: 'space-between', alignItems: 'center' }}>
              <span>Welcome to the Blogger Application! Use the left sidebar menu to navigate catalog sections.</span>
              <button 
                onClick={() => setBannerClosed(true)}
                style={{ background: 'none', border: 'none', cursor: 'pointer', fontSize: '16px', fontWeight: 'bold' }}
              >
                &times;
              </button>
            </div>
          ) : null}

          {/* Render Active Tab Content Panel */}
          {renderContent()}
        </div>
      </main>
    </div>
  );
}

export default App;
