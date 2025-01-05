"use client";
import React, { useState } from "react";
import Image from "next/image";
import TabButton from "./TabButton";

const TAB_DATA = [
  {
    title: "Skills",
    id: "skills",
    content: (
      <ul className="list-disc pl-5">
        <li>Core Java</li>
        <li>Spring Boot</li>
        <li>Postgresql</li>
        <li>Next.js</li>
        <li>Wordpress</li>
        <li>Adobe Creative Suite</li>
      </ul>
    ),
  },
  {
    title: "Education",
    id: "education",
    content: (
      <ul className="list-disc pl-5">
        <li>University of Zimbabwe</li>
      </ul>
    ),
  },
  {
    title: "Experience",
    id: "experience",
    content: (
      <ul className="list-disc pl-5">
        <li>Software Developer at Data-Age Systems</li>
        <li>Software Developer at Cashlinq</li>
        <li>IT technician at GAWPS</li>
      </ul>
    ),
  },
];

const AboutSection = () => {
  const [tab, setTab] = useState("skills");

  const handleTabChange = (id) => {
    setTab(id);
  };

  return (
    <section className="text-white bg-gray-900 py-16" id="about">
      <div className="container mx-auto px-6 lg:px-20">
        <h2 className="text-4xl text-center font-bold text-white mb-8">About Me</h2>
        <div className="flex flex-col lg:flex-row items-center">
          <div className="w-full lg:w-1/3 mb-8 lg:mb-0">
            <Image
              src="/images/profile-image.png"
              alt="Profile Picture"
              width={300}
              height={300}
              className="rounded-full mx-auto"
            />
          </div>
          <div className="w-full lg:w-2/3 lg:pl-12">
            <p className="text-lg mb-6">
              I’m a Software Developer with a degree in Computer Engineering from the University of Zimbabwe.
              I specialize in building robust APIs and scalable systems with Spring Boot, creating custom WordPress themes and plugins,
              and developing modern web solutions with Next.js. My projects range from e-commerce platforms to intelligent resource management systems.
              Proficient in Java, SQL, Adobe Creative Suite, and modern web technologies,
              I combine technical expertise and creativity to deliver impactful, user-focused solutions.
            </p>
            <div className="flex flex-row justify-start mb-6">
              {TAB_DATA.map((tabData) => (
                <TabButton
                  key={tabData.id}
                  selectTab={() => handleTabChange(tabData.id)}
                  active={tab === tabData.id}
                >
                  {tabData.title}
                </TabButton>
              ))}
            </div>
            <div className="transition-all duration-500 ease-in-out">
              {TAB_DATA.find((t) => t.id === tab).content}
            </div>
          </div>
        </div>
      </div>
    </section>
  );
};

export default AboutSection;