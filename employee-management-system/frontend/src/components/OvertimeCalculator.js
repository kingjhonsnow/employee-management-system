import React, { useState } from 'react';

function OvertimeCalculator() {
  const [employeId, setEmployeId] = useState('');
  const [startDate, setStartDate] = useState('');
  const [endDate, setEndDate] = useState('');
  const [overtime, setOvertime] = useState(null);

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      const response = await fetch(
        `http://localhost:8080/overtime?employeId=${employeId}&startDate=${startDate}&endDate=${endDate}`,
        { method: 'POST' }
      );
      const data = await response.json();
      setOvertime(data);
    } catch (error) {
      console.error('Error calculating overtime:', error);
    }
  };

  return (
    <div className="overtime-calculator">
      <h2>Calculate Overtime</h2>
      <form onSubmit={handleSubmit}>
        <input
          type="number"
          placeholder="Employee ID"
          value={employeId}
          onChange={(e) => setEmployeId(e.target.value)}
          required
        />
        <input
          type="date"
          value={startDate}
          onChange={(e) => setStartDate(e.target.value)}
          required
        />
        <input
          type="date"
          value={endDate}
          onChange={(e) => setEndDate(e.target.value)}
          required
        />
        <button type="submit">Calculate</button>
      </form>
      {overtime !== null && (
        <p className="overtime-result">Total Overtime: {overtime} hours</p>
      )}
    </div>
  );
}

export default OvertimeCalculator;