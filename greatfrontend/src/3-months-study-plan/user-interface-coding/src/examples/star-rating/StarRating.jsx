import { useState } from "react";
import "./StarRating.css";

export default function StarRating({
  maxStars = 5,
  initialFilled = 0,
  onChange,
}) {
  const [currentHoveredIndex, setCurrentHoveredIndex] = useState(null);
  const [filled, setFilled] = useState(initialFilled);

  // If hovering, use hover index; otherwise use filled state
  const filledCount =
    currentHoveredIndex !== null ? currentHoveredIndex + 1 : filled;

  return (
    <div className="star-rating-container">
      <div
        className="star-rating"
        onMouseLeave={() => setCurrentHoveredIndex(null)}
      >
        {[...Array(maxStars)].map((_, index) => {
          const isFilled = index < filledCount;

          return (
            <svg
              key={index}
              xmlns="http://www.w3.org/2000/svg"
              className={`star-icon ${isFilled ? "star-icon-filled" : ""}`}
              fill="none"
              viewBox="0 0 24 24"
              stroke="currentColor"
              strokeWidth="2"
              onMouseEnter={() => setCurrentHoveredIndex(index)}
              onClick={() => {
                setFilled(index + 1);
                if (onChange) onChange(index + 1);
              }}
            >
              <path
                strokeLinecap="round"
                strokeLinejoin="round"
                d="M11.049 2.927c.3-.921 1.603-.921 1.902 0l1.519 4.674a1 1 0 00.95.69h4.915c.969 0 1.371 1.24.588 1.81l-3.976 2.888a1 1 0 00-.363 1.118l1.518 4.674c.3.922-.755 1.688-1.538 1.118l-3.976-2.888a1 1 0 00-1.176 0l-3.976 2.888c-.783.57-1.838-.197-1.538-1.118l1.518-4.674a1 1 0 00-.363-1.118l-3.976-2.888c-.784-.57-.38-1.81.588-1.81h4.914a1 1 0 00.951-.69l1.519-4.674z"
              />
            </svg>
          );
        })}
      </div>
      <p className="rating-text">
        {filled} out of {maxStars} stars
      </p>
    </div>
  );
}
