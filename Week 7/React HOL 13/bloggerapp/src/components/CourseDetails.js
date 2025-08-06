import React from "react";

const courses = [
  { title: "React Basics", startDate: "2025-09-01" },
  { title: "Advanced JavaScript", startDate: "2025-10-15" },
  { title: "UI/UX Design", startDate: "2025-11-10" },
];

function CourseDetails({ show }) {
  // Conditional rendering: using &&
  return (
    show && (
      <div>
        <h2>Course Details</h2>
        {courses.map((course, idx) => (
          <div key={idx} style={{ marginBottom: "1rem" }}>
            <div>
              <b>{course.title}</b>
            </div>
            <div>Start Date: {course.startDate}</div>
          </div>
        ))}
      </div>
    )
  );
}

export default CourseDetails;
