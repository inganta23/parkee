import { BrowserRouter as Router, Routes, Route } from "react-router";
import CheckIn from "./pages/CheckIn";
import CheckOut from "./pages/CheckOut";
import Navbar from "./components/ui/navbar";

function App() {
  return (
    <Router>
      <Navbar />

      <div className="container mx-auto p-4">
        <Routes>
          <Route path="/" element={<CheckIn />} />
          <Route path="/check-out" element={<CheckOut />} />
        </Routes>
      </div>
    </Router>
  );
}

export default App;
