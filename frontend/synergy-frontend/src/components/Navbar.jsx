import React from "react";
import { Link } from "react-router-dom";

const Navbar = () => {
  return (
    <nav style={styles.navbar}>
      <div style={styles.logo}>
        <Link to="/" style={styles.link}>
          SynergySphere
        </Link>
      </div>
      <ul style={styles.navLinks}>
        <li>
          <Link to="/projects" style={styles.link}>
            Projects
          </Link>
        </li>
        <li>
          <Link to="/tasks" style={styles.link}>
            Tasks
          </Link>
        </li>
        <li>
          <Link to="/users" style={styles.link}>
            Users
          </Link>
        </li>
        <li>
          <Link to="/login" style={styles.link}>
            Login
          </Link>
        </li>
        <li>
          <Link to="/signup" style={styles.link}>
            Signup
          </Link>
        </li>
        <li>
          <Link to="/logout" style={styles.link}>
            Logout
          </Link>
        </li>
      </ul>
    </nav>
  );
};

const styles = {
  navbar: {
    display: "flex",
    justifyContent: "space-between",
    alignItems: "center",
    padding: "10px 20px",
    backgroundColor: "#1f2937", // gray-800
    color: "#fff",
  },
  logo: {
    fontSize: "1.5rem",
    fontWeight: "bold",
  },
  navLinks: {
    listStyleType: "none",
    display: "flex",
    gap: "15px",
  },
  link: {
    textDecoration: "none",
    color: "#fff",
    fontWeight: "500",
  },
};

export default Navbar;
