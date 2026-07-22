import React from 'react';
import styles from './CohortDetails.module.css';

const CohortDetails = ({ cohort }) => {
  // Define style for h3: green if ongoing, blue in all other scenarios.
  const titleStyle = {
    color: cohort.status === 'ongoing' ? 'green' : 'blue'
  };

  return (
    <div className={styles.box}>
      <h3 style={titleStyle}>{cohort.name}</h3>
      <dl>
        <dt>Start Date</dt>
        <dd>{cohort.startDate}</dd>

        <dt>End Date</dt>
        <dd>{cohort.endDate}</dd>

        <dt>Status</dt>
        <dd>{cohort.status}</dd>

        <dt>Number of Students</dt>
        <dd>{cohort.students}</dd>
      </dl>
    </div>
  );
};

export default CohortDetails;
