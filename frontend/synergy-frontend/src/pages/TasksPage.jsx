import React, { useEffect, useState } from "react";

const TaskPage = () => {
  const [tasks, setTasks] = useState([]);

  useEffect(() => {
    const fetchTasks = async () => {
      const token = localStorage.getItem("token");
      const response = await fetch("http://localhost:8081/api/tasks", {
        headers: { Authorization: `Bearer ${token}` },
      });
      const data = await response.json();
      setTasks(data);
    };
    fetchTasks();
  }, []);

  return (
    <div style={{ padding: "2rem" }}>
      <h2>Tasks</h2>
      <ul>
        {tasks.map((task) => (
          <li key={task.taskId}>
            {task.title} - {task.status} - Priority: {task.priority} - Deadline:{" "}
            {task.deadline}
          </li>
        ))}
      </ul>
    </div>
  );
};

export default TaskPage;
