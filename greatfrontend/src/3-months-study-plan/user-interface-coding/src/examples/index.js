import HolyGrail from "./holy-grail/HolyGrail";
import StarRating from "./star-rating/StarRating";
import TemperatureConverter from "./temperature-converter/TemperatureConverter";
import TodoList from "./to-do-list/TodoList";
import Tweet from "./tweet/Tweet";

export const examples = [
  {
    id: "tweet",
    name: "Tweet",
    component: Tweet,
    description: "Build a component that resembles a Tweet from Twitter",
  },
  {
    id: "holy-grail",
    name: "Holy Grail",
    component: HolyGrail,
    description:
      "Build the famous holy grail layout consisting of a header, 3 columns, and a footer",
  },
  {
    id: "to-do-list",
    name: "To-Do List",
    component: TodoList,
    description:
      "Build a Todo list that lets users add new tasks and delete existing tasks",
  },
  {
    id: "temperature-converter",
    name: "Temperature Converter",
    component: TemperatureConverter,
    description:
      "Build a temperature converter widget that converts temperature values between Celsius and Fahrenheit",
  },
  {
    id: "star-rating",
    name: "Star Rating",
    component: StarRating,
    description:
      "Build a star rating component that allows users to rate items by selecting stars",
  },
];
