const thmBtn = document.getElementById("toggleTheme");

let htmlTag = document.querySelector("html");
const themeIcon = document.getElementById("toggleTheme")?.children[0];
console.log(thmBtn);

let currentTheme = getTheme();
console.log("Curr theme: ", currentTheme);

//Initial
//when window is loaded
document.addEventListener("DOMContentLoaded", () => {
  changePageTheme(currentTheme, null);

  thmBtn.addEventListener("click", () => {
    console.log("Theme button clicked");
    toggleTheme();
  });
});

function toggleTheme() {
    const oldTheme = currentTheme;

    // Toggle theme,updating currentTheme.
    currentTheme = (currentTheme === "dark") ? "light" : "dark";
  
    changePageTheme(currentTheme, oldTheme);

}

function changePageTheme(theme, oldTheme) {
   // Set theme in local storage
   setTheme(theme);

   // Remove old theme
   if (oldTheme) {
     htmlTag.classList.remove(oldTheme);
   }
 
   // Add new theme to the HTML tag
   htmlTag.classList.add(theme);
 
   // Change icon
   if (theme === "light") {
     // Set Moon icon
     themeIcon.classList.contains("fa-sun") && themeIcon.classList.remove("fa-sun");
     themeIcon.classList.add("fa-moon");
     themeIcon.style.color = "#000";
   } else if (theme === "dark") {
     // Set Sun icon
     themeIcon.classList.contains("fa-moon") && themeIcon.classList.remove("fa-moon");
     themeIcon.classList.add("fa-sun");
     themeIcon.style.color = "#fff";
   }
 
   console.log("Theme changed to: ", theme);
}

function setTheme(theme) {
  localStorage.setItem("theme", theme);
}

function getTheme() {
  const theme = localStorage.getItem("theme");
  return theme ? theme : "light";
}
