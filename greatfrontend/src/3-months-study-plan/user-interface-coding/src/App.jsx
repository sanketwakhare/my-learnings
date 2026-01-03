import { Routes, Route } from "react-router-dom";
import "./App.css";
import Layout from "./components/Layout";
import Home from "./components/Home";
import Tweet from "./examples/tweet/Tweet";
import HolyGrail from "./examples/holy-grail/HolyGrail";
import TodoList from "./examples/to-do-list/TodoList";
import TemperatureConverter from "./examples/temperature-converter/TemperatureConverter";
import StarRating from "./examples/star-rating/StarRating";
import ContactForm from "./examples/contact-form/ContactForm";

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
        <Route
          path="star-rating"
          element={<StarRating maxStars={5} initialFilled={3} />}
        />
        <Route path="contact-form" element={<ContactForm />} />
      </Route>
    </Routes>
  );
}
