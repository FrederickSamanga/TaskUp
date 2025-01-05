"use client";
import React, { useEffect, useState } from "react";
import CountUp from 'react-countup';

const achievementsList = [
  {
    metric: "Experience",
    value: 3,
    postfix: "",
  },
  {
    metric: "Projects",
    value: 15,
    postfix: "+",
  },
  {
    metric: "Websites",
    value: 10,
    postfix: "",
  },
  {
    metric: "Designs",
    value: 500,
    postfix: "+",
  },
  {
    metric: "Clients",
    value: 10,
    postfix: "+",
  },
];

const AchievementsSection = () => {
  const [achievements, setAchievements] = useState([]);

  useEffect(() => {
    // Set achievements immediately after component mounts
    setAchievements(achievementsList);
  }, []);

  return (
    <div className="mt-16 mb-24"> 
      <div className="sm:border-[#33353F] sm:border rounded-md py-8 px-6 flex flex-col sm:flex-row items-center justify-between">
        {achievements.map((achievement, index) => (
          <div
            key={`${achievement.metric}-${index}`} // Unique key for React
            className="flex flex-col items-center justify-center mx-4 my-4 sm:my-0"
          >
            <h2 className="text-white text-4xl font-bold flex flex-row">
              {achievement.prefix || ""}
              <CountUp end={achievement.value} duration={5} />
              {achievement.postfix || ""}
            </h2>
            <p className="text-[#ADB7BE] text-base">{achievement.metric}</p>
          </div>
        ))}
      </div>
    </div>
  );
};

export default AchievementsSection;