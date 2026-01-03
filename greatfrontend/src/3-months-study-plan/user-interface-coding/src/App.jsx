import { Routes, Route } from "react-router-dom";
import "./App.css";
import Layout from "./components/Layout";
import Home from "./components/Home";
import Tweet from "./examples/tweet/Tweet";
import HolyGrail from "./examples/holy-grail/HolyGrail";
import TodoList from "./examples/to-do-list/TodoList";
import TemperatureConverter from "./examples/temperature-converter/TemperatureConverter";

export default function App() {
  return (
    <Routes>
      <Route path="/" element={<Layout />}>
        <Route index element={<Home />} />
        <Route path="tweet" element={<Tweet />} />
        <Route path="holy-grail" element={<HolyGrail />} />
        <Route path="to-do-list" element={<TodoList />} />
        <Route
          path="temperature-converter"
          element={<TemperatureConverter />}
        />
      </Route>
    </Routes>
  );
}
