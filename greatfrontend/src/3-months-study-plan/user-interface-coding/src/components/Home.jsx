// src/components/Home.jsx
import { useState, useMemo } from "react";
import { Link } from "react-router-dom";
import { examples } from "../examples";

export default function Home() {
  const [searchQuery, setSearchQuery] = useState("");

  // Filter examples based on search query
  const filteredExamples = useMemo(() => {
    if (!searchQuery.trim()) {
      return examples;
    }

    const query = searchQuery.toLowerCase();
    return examples.filter(
      (example) =>
        example.name.toLowerCase().includes(query) ||
        example.description.toLowerCase().includes(query)
    );
  }, [searchQuery]);

  return (
    <div className="home">
      <h1>UI Examples & Solutions</h1>
      <p>Click on any example to view the solution</p>

      {/* Search Box */}
      <div className="search-container">
        <div className="search-box">
          <svg
            className="search-icon"
            width="20"
            height="20"
            viewBox="0 0 24 24"
            fill="none"
            stroke="currentColor"
            strokeWidth="2"
          >
            <circle cx="11" cy="11" r="8"></circle>
            <path d="m21 21-4.35-4.35"></path>
          </svg>
          <input
            type="text"
            placeholder="Search examples by name or description..."
            value={searchQuery}
            onChange={(e) => setSearchQuery(e.target.value)}
            className="search-input"
          />
          {searchQuery && (
            <button
              onClick={() => setSearchQuery("")}
              className="clear-button"
              aria-label="Clear search"
            >
              ✕
            </button>
          )}
        </div>
      </div>

      {/* Results count */}
      {searchQuery && (
        <div className="search-results-info">
          {filteredExamples.length === 0 ? (
            <p>
              No examples found matching "<strong>{searchQuery}</strong>"
            </p>
          ) : (
            <p>
              Found {filteredExamples.length}{" "}
              {filteredExamples.length === 1 ? "example" : "examples"}
            </p>
          )}
        </div>
      )}

      {/* Examples Grid */}
      {filteredExamples.length > 0 ? (
        <div className="examples-grid">
          {filteredExamples.map((example) => (
            <Link
              key={example.id}
              to={`/${example.id}`}
              className="example-card"
            >
              <h3>{example.name}</h3>
              <p>{example.description}</p>
            </Link>
          ))}
        </div>
      ) : (
        <div className="no-results">
          <div className="no-results-icon">🔍</div>
          <h3>No examples found</h3>
          <p>Try searching with different keywords</p>
        </div>
      )}
    </div>
  );
}
