import { Outlet, Link, useLocation } from "react-router-dom";
import { examples } from "../examples";

export default function Layout() {
  const location = useLocation();
  const isHome = location.pathname === "/";

  const currentExample = examples.find(
    (ex) => location.pathname === `/${ex.id}`
  );

  return (
    <div className="app">
      {!isHome && (
        <nav className="navbar">
          <Link to="/" className="back-button">
            Back to Examples
          </Link>
          <h2>{currentExample?.name}</h2>
        </nav>
      )}
      <div className={isHome ? "" : "example-view"}>
        <Outlet />
      </div>
    </div>
  );
}
