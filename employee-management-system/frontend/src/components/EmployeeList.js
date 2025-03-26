import React, { useEffect, useState } from 'react';

function EmployeeList() {
  const [employees, setEmployees] = useState([]);

  useEffect(() => {
    fetch('http://localhost:8080/employees')
      .then(response => response.json())
      .then(data => setEmployees(data))
      .catch(error => console.error('Error fetching employees:', error));
  }, []);

  return (
    <div className="employee-list">
      <h2>Employee List</h2>
      <ul>
        {employees.map(employee => (
          <li key={employee.id}>
            <span>{employee.nom} {employee.prenom}</span>
            <span>{employee.poste}</span>
          </li>
        ))}
      </ul>
    </div>
  );
}

export default EmployeeList;