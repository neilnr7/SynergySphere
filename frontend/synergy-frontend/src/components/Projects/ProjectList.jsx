import { useEffect, useState } from "react";
import API from "../../api/api";

export default function ProjectList({ refresh }) {
  const [projects, setProjects] = useState([]);

  useEffect(() => {
    API.get("/projects")
      .then((res) => setProjects(res.data))
      .catch((err) => console.error(err));
  }, [refresh]);

  if (projects.length === 0) {
    return <p className="text-gray-500">No projects yet. Create one above! 🚀</p>;
  }

  // Helper for badge styles
  const getStatusClasses = (status) => {
    switch (status) {
      case "Completed":
        return "bg-green-100 text-green-700";
      case "Ongoing":
        return "bg-blue-100 text-blue-700";
      case "Pending":
        return "bg-gray-200 text-gray-600";
      default:
        return "bg-purple-100 text-purple-700";
    }
  };

  return (
    <div className="grid grid-cols-1 sm:grid-cols-2 lg:grid-cols-3 gap-6">
      {projects.map((p) => (
        <div
          key={p.projectId}
          className="border rounded-xl p-5 bg-white shadow hover:shadow-lg transition"
        >
          {/* Header with project name + priority */}
          <div className="flex justify-between items-center mb-3">
            <h3 className="font-bold text-lg text-gray-800">{p.name}</h3>
            <span
              className={`px-3 py-1 text-sm rounded-full ${
                p.priority === "High"
                  ? "bg-red-100 text-red-700"
                  : p.priority === "Medium"
                  ? "bg-yellow-100 text-yellow-700"
                  : "bg-green-100 text-green-700"
              }`}
            >
              {p.priority}
            </span>
          </div>

          {/* Description */}
          <p className="text-gray-600 mb-4">{p.projectDescription}</p>

          {/* Footer with deadline + status */}
          <div className="flex justify-between items-center text-sm">
            <p className="text-gray-500 flex items-center gap-1">
              📅 Deadline: {p.deadline}
            </p>
            {p.status && (
              <span
                className={`px-3 py-1 rounded-full text-xs font-medium ${getStatusClasses(
                  p.status
                )}`}
              >
                {p.status}
              </span>
            )}
          </div>
        </div>
      ))}
    </div>
  );
}
