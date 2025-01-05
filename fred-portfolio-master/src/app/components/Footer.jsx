import React from "react";

const Footer = () => {
  return (
    <footer className="footer border z-10 border-t-[#33353F] border-l-transparent border-r-transparent text-white">
      <div className="container p-12 flex justify-between">
        <span>
          <img
            src="/j-expression2.png"
            alt="Logo"
            className="h-4 px-4 md:h-8 "
          />
        </span>
        <p className="text-slate-600">&copy; 2025 J-Expression. All rights reserved.</p>
      </div>
    </footer>
  );
};

export default Footer;
