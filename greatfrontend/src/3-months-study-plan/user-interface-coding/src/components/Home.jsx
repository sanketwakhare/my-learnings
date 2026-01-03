import { Link } from 'react-router-dom';
import { examples } from '../examples';

export default function Home() {
  return (
    <div className="home">
      <h1>UI Examples & Solutions</h1>
      <p>Click on any example to view the solution</p>
      
      <div className="examples-grid">
        {examples.map(example => (
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
    </div>
  );
}