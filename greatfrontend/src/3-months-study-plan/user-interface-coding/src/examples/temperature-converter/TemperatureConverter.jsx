import { useState } from "react";
import "./TemperatureConverter.css";

const NUMBER_INPUT_REGEX = /^\d*\.?\d*$/;
const MORE_THAN_FIVE_DECIMALS_REGEX = /^\d+(\.\d{5,})$/;

// formula: F = C * 9/5 + 32
export default function TemperatureConverter() {
  const [celsius, setCelsius] = useState("");
  const [fahrenheit, setFahrenheit] = useState("");

  const formatNumber = (num) => {
    if (MORE_THAN_FIVE_DECIMALS_REGEX.test(num)) {
      return parseFloat(num).toFixed(4);
    }
    return num;
  };

  const handleCelsiusChange = (e) => {
    const value = e.target.value;
    if (NUMBER_INPUT_REGEX.test(value)) {
      setCelsius(value);
      if (value !== "") {
        setFahrenheit(formatNumber((parseFloat(value) * 9) / 5 + 32));
      } else {
        setFahrenheit("");
      }
    }
  };

  const handleFahrenheitChange = (e) => {
    const value = e.target.value;
    if (NUMBER_INPUT_REGEX.test(value)) {
      setFahrenheit(value);
      if (value !== "") {
        setCelsius(formatNumber(((parseFloat(value) - 32) * 5) / 9));
      } else {
        setCelsius("");
      }
    }
  };

  return (
    <div className="temperatureConverterContainer">
      <div className="celsiusColumn">
        <input
          id="celsius"
          type="text"
          value={celsius}
          onChange={handleCelsiusChange}
        />
        <label htmlFor="celsius">Celsius</label>
      </div>
      <div className="equalsSign">=</div>
      <div className="fahrenheitColumn">
        <input
          id="fahrenheit"
          type="text"
          value={fahrenheit}
          onChange={handleFahrenheitChange}
        />
        <label htmlFor="fahrenheit">Fahrenheit</label>
      </div>
    </div>
  );
}
