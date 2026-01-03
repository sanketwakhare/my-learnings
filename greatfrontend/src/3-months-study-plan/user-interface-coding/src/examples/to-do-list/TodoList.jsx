import { useState } from "react";
import "./TodoList.css";

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
      setNewTask("");
    }
  };

  const handleKeyPress = (e) => {
    if (e.key === "Enter") {
      addTask();
    }
  };

  const deleteTask = (index) => {
    const filteredTasks = tasks.filter((_, ind) => ind !== index);
    setTasks(filteredTasks);
  };

  return (
    <div className="todo-container">
      <div className="todo-card">
        <h1 className="todo-title">📝 Todo List</h1>
        <p className="todo-subtitle">
          {tasks.length} {tasks.length === 1 ? "task" : "tasks"} remaining
        </p>

        <div className="input-section">
          <input
            type="text"
            placeholder="Add a new task..."
            value={newTask}
            onChange={(e) => setNewTask(e.target.value)}
            onKeyPress={handleKeyPress}
            className="task-input"
          />
          <button onClick={addTask} className="add-button">
            Add Task
          </button>
        </div>

        {tasks.length === 0 ? (
          <div className="empty-state">
            <div className="empty-icon">✓</div>
            <p>No tasks yet. Add one above!</p>
          </div>
        ) : (
          <ul className="task-list">
            {tasks.map((task, index) => (
              <li key={index} className="task-item">
                <span className="task-text">{task}</span>
                <button
                  onClick={() => deleteTask(index)}
                  className="delete-button"
                  aria-label="Delete task"
                >
                  ✕
                </button>
              </li>
            ))}
          </ul>
        )}
      </div>
    </div>
  );
}
