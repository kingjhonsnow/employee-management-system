
import React from 'react';
import EmployeeList from './components/EmployeeList';
import OvertimeCalculator from './components/OvertimeCalculator';
import './App.css'; // Make sure to import the CSS file

function App() {
  return (
    <div className="App">
      <h1>Employee Management System</h1>
      <EmployeeList />
      <OvertimeCalculator />
    </div>
  );
}

export default App;