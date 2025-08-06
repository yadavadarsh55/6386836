import "./App.css";
import CourseDetails from "./components/CourseDetails";
import BookDetails from "./components/BookDetails";
import BlogDetails from "./components/BlogDetails";

function App() {
  // Example: all columns visible, you can toggle these to test conditional rendering
  const showCourses = true;
  const showBooks = true;
  const showBlogs = true;

  return (
    <div
      className="App"
      style={{
        minHeight: "100vh",
        display: "flex",
        alignItems: "flex-start",
        justifyContent: "center",
        background: "#f5f5f5",
        padding: "2rem",
      }}
    >
      <div
        style={{ display: "flex", width: "100%", maxWidth: 1200, gap: "2rem" }}
      >
        {/* Conditional rendering using && in CourseDetails */}
        <div
          style={{
            flex: 1,
            background: "#fff",
            padding: "1rem",
            borderRadius: 8,
            boxShadow: "0 2px 8px #0001",
          }}
        >
          <CourseDetails show={showCourses} />
        </div>
        {/* Conditional rendering using ternary in BookDetails */}
        <div
          style={{
            flex: 1,
            background: "#fff",
            padding: "1rem",
            borderRadius: 8,
            boxShadow: "0 2px 8px #0001",
          }}
        >
          <BookDetails show={showBooks} />
        </div>
        {/* Conditional rendering using if in BlogDetails */}
        <div
          style={{
            flex: 1,
            background: "#fff",
            padding: "1rem",
            borderRadius: 8,
            boxShadow: "0 2px 8px #0001",
          }}
        >
          <BlogDetails show={showBlogs} />
        </div>
      </div>
    </div>
  );
}

export default App;
