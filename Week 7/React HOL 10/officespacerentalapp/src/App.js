import "./App.css";

function App() {
  // Office rental data
  const offices = [
    {
      name: "Skyline Tower",
      rent: 55000,
      address: "123 Main St, Mumbai",
      image:
        "https://images.unsplash.com/photo-1506744038136-46273834b3fb?auto=format&fit=crop&w=600&q=80",
    },
    {
      name: "Tech Park One",
      rent: 75000,
      address: "456 Tech Ave, Bengaluru",
      image:
        "https://images.unsplash.com/photo-1464983953574-0892a716854b?auto=format&fit=crop&w=600&q=80",
    },
    {
      name: "Business Bay",
      rent: 62000,
      address: "789 Corporate Rd, Pune",
      image:
        "https://images.unsplash.com/photo-1465101046530-73398c7f28ca?auto=format&fit=crop&w=600&q=80",
    },
    
  ];

  return (
    <div className="App">
      <h1 className="page-heading">Office Space Rentals</h1>
      <div className="office-list">
        {offices.map((office, idx) => (
          <div className="office-card" key={idx}>
            <img
              src={office.image}
              alt={office.name}
              className="office-image"
            />
            <h2>{office.name}</h2>
            <p>
              <strong>Address:</strong> {office.address}
            </p>
            <p>
              <strong>Rent:</strong>{" "}
              <span
                style={{
                  color: office.rent < 60000 ? "red" : "green",
                  fontWeight: "bold",
                }}
              >
                ₹{office.rent.toLocaleString()}
              </span>
            </p>
          </div>
        ))}
      </div>
    </div>
  );
}

export default App;
