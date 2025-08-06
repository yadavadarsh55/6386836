import React, { useState } from "react";

function CurrencyConvertor() {
  const [inputType, setInputType] = useState("rupees");
  const [amount, setAmount] = useState("");
  const conversionRate = 101.0691;

  const handleTypeChange = (e) => {
    setInputType(e.target.value);
    setAmount("");
  };

  const handleAmountChange = (e) => {
    setAmount(e.target.value);
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    if (amount === "" || isNaN(amount)) {
      alert("Please enter a valid number.");
      return;
    }
    let result;
    if (inputType === "rupees") {
      result = (parseFloat(amount) / conversionRate).toFixed(2);
      alert(`${amount} Rupees = €${result} Euros`);
    } else {
      result = (parseFloat(amount) * conversionRate).toFixed(2);
      alert(`€${amount} Euros = ${result} Rupees`);
    }
  };

  return (
    <div>
      <h2>Currency Convertor</h2>
      <form onSubmit={handleSubmit}>
        <label>
          <input
            type="radio"
            value="rupees"
            checked={inputType === "rupees"}
            onChange={handleTypeChange}
          />
          Rupees to Euro
        </label>
        <label style={{ marginLeft: "1rem" }}>
          <input
            type="radio"
            value="euros"
            checked={inputType === "euros"}
            onChange={handleTypeChange}
          />
          Euro to Rupees
        </label>
        <div>
          <input
            type="number"
            value={amount}
            onChange={handleAmountChange}
            placeholder={
              inputType === "rupees"
                ? "Enter amount in INR"
                : "Enter amount in Euro"
            }
            min="0"
            step="any"
          />
        </div>
        <button type="submit">Convert</button>
      </form>
    </div>
  );
}

export default CurrencyConvertor;
