import { useState } from "react";
import API from "../../api/api";

export default function ProjectForm({ onProjectCreated }) {
  const [name, setName] = useState("");
  const [description, setDescription] = useState("");
  const [priority, setPriority] = useState("Medium");
  const [deadline, setDeadline] = useState("");
  const [message, setMessage] = useState("");

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      await API.post("/projects", {
        name,
        projectDescription: description,
        priority,
        deadline,
        managerId: 1,
      });
      setMessage("✅ Project created!");
      setName("");
      setDescription("");
      setDeadline("");
      onProjectCreated?.();
    } catch (err) {
      setMessage(err.response?.data?.message || "❌ Error creating project!");
    }
  };

  return (
    <form onSubmit={handleSubmit} className="space-y-4">
      <div className="grid grid-cols-1 md:grid-cols-5 gap-4">
        <input
          className="border p-2 rounded w-full"
          placeholder="Project Name"
          value={name}
          onChange={(e) => setName(e.target.value)}
        />
        <input
          className="border p-2 rounded w-full"
          placeholder="Description"
          value={description}
          onChange={(e) => setDescription(e.target.value)}
        />
        <select
          className="border p-2 rounded w-full"
          value={priority}
          onChange={(e) => setPriority(e.target.value)}
        >
          <option value="Low">Low</option>
          <option value="Medium">Medium</option>
          <option value="High">High</option>
        </select>
        <input
          type="date"
          className="border p-2 rounded w-full"
          value={deadline}
          onChange={(e) => setDeadline(e.target.value)}
        />
        <button
          type="submit"
          className="bg-blue-600 text-white px-4 py-2 rounded hover:bg-blue-700 transition"
        >
          Create
        </button>
      </div>
      {message && <p className="text-green-600 font-medium">{message}</p>}
    </form>
  );
}
