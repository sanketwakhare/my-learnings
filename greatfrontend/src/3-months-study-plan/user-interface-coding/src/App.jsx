import { useState } from 'react';
import { examples } from './examples';
import './App.css';

export default function App() {
  const [currentExample, setCurrentExample] = useState(null);

  const CurrentComponent = currentExample 
    ? examples.find(ex => ex.id === currentExample)?.component 
    : null;

  return (
    <div className="app">
      {!currentExample ? (
        <div className="home">
          <h1>UI Examples & Solutions</h1>
          <p>Click on any example to view the solution</p>
          
          <div className="examples-grid">
            {examples.map(example => (
              <div 
                key={example.id}
                className="example-card"
                onClick={() => setCurrentExample(example.id)}
              >
                <h3>{example.name}</h3>
                <p>{example.description}</p>
              </div>
            ))}
          </div>
        </div>
      ) : (
        <div>
          <nav className="navbar">
            <button onClick={() => setCurrentExample(null)}>
              ← Back to Examples
            </button>
            <h2>
              {examples.find(ex => ex.id === currentExample)?.name}
            </h2>
          </nav>
          <div className="example-view">
            {CurrentComponent && <CurrentComponent />}
          </div>
        </div>
      )}
    </div>
  );
}