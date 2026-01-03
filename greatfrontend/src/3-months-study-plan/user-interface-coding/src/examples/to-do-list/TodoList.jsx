import { useState } from "react";

export default function TodoList() {
  const [tasks, setTasks] = useState([
    "Walk the dog",
    "Water the plants",
    "Wash the dishes",
  ]);
  const [newTask, setNewTask] = useState("");

  const addTask = () => {
    if (newTask.trim() !== "") {
      const updateTaskList = [...tasks, newTask];
      setTasks(updateTaskList);
      // clear input field
      setNewTask("");
    }
  };

  const deleteTask = (index) => {
    const filteredTasks = tasks.filter((_, ind) => ind !== index);
    setTasks(filteredTasks);
  };

  return (
    <div>
      <h1>Todo List</h1>
      <div>
        <input
          type="text"
          placeholder="Add your task"
          value={newTask}
          onChange={(e) => {
            const name = e.target.value;
            setNewTask(name);
          }}
        />
        <div>
          <button onClick={addTask}>Submit</button>
        </div>
      </div>
      <ul>
        {tasks.map((task, index) => {
          return (
            <li key={index}>
              <span>{task}</span>
              <button onClick={() => deleteTask(index)}>Delete</button>
            </li>
          );
        })}
      </ul>
    </div>
  );
}
