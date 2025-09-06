import { useState } from "react";
import ProjectForm from "./ProjectForm";
import ProjectList from "./ProjectList";

export default function ProjectsPage() {
  const [refresh, setRefresh] = useState(false);

  const handleProjectCreated = () => {
    setRefresh(!refresh);
  };

  return (
    <div className="max-w-6xl mx-auto p-6">
      <h1 className="text-4xl font-bold mb-8 text-gray-800 flex items-center gap-2">
        📂 Projects
      </h1>

      {/* Project Form */}
      <div className="bg-white shadow-lg rounded-2xl p-6 mb-10 border">
        <h2 className="text-2xl font-semibold mb-4 text-gray-700 flex items-center gap-2">
          ➕ Create Project
        </h2>
        <ProjectForm onProjectCreated={handleProjectCreated} />
      </div>

      {/* Project List */}
      <div>
        <h2 className="text-2xl font-semibold mb-6 text-gray-700 flex items-center gap-2">
          📋 Project List
        </h2>
        <ProjectList refresh={refresh} />
      </div>
    </div>
  );
}
