import React from 'react';

// Extracted CourseItem component representing a list item with keys
function CourseItem({ course }) {
  return (
    <div style={{ padding: '15px', borderBottom: '1px solid #eee', textAlign: 'left' }}>
      <h4 style={{ margin: '0 0 5px 0', color: '#27ae60' }}>{course.title}</h4>
      <p style={{ margin: '0 0 5px 0', fontSize: '13px', color: '#666' }}>
        Instructor: <strong>{course.instructor}</strong> | Duration: {course.duration}
      </p>
      <p style={{ margin: 0, fontSize: '13px', color: '#444' }}>{course.description}</p>
    </div>
  );
}

const CourseDetails = ({ courses }) => {
  return (
    <div style={{ background: '#fff', padding: '20px', borderRadius: '8px', boxShadow: '0 4px 8px rgba(0,0,0,0.05)' }}>
      <h3 style={{ margin: '0 0 15px 0', color: '#333' }}>Available Courses</h3>
      {courses.length === 0 ? (
        <p>No courses listed.</p>
      ) : (
        <div>
          {courses.map(course => (
            // Passing the unique key prop to the extracted component
            <CourseItem key={course.id} course={course} />
          ))}
        </div>
      )}
    </div>
  );
};

export default CourseDetails;
