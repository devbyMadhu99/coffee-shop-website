
// ===============================
// Navbar / Mobile Menu
const navbarLinks = document.querySelectorAll(".nav-menu .nav-link");
const menuOpenButton = document.querySelector("#menu-open-button");
const menuCloseButton = document.querySelector("#menu-close-button");

if (menuOpenButton) {
  menuOpenButton.addEventListener("click", () => {
    document.body.classList.toggle("show-mobile-menu");
  });
}

if (menuCloseButton) {
  menuCloseButton.addEventListener("click", () => {
    document.body.classList.remove("show-mobile-menu");
  });
}

navbarLinks.forEach((link) => {
  link.addEventListener("click", () => {
    document.body.classList.remove("show-mobile-menu");
  });
});


// ===============================
// Swiper Slider
// ===============================

let swiper = new Swiper(".slider-wrapper", {
  loop: true,
  grabCursor: true,
  spaceBetween: 25,

  pagination: {
    el: ".swiper-pagination",
    clickable: true,
    dynamicBullets: true,
  },

  navigation: {
    nextEl: ".swiper-button-next",
    prevEl: ".swiper-button-prev",
  },

  breakpoints: {
    0: {
      slidesPerView: 1,
    },
    768: {
      slidesPerView: 2,
    },
    1024: {
      slidesPerView: 3,
    },
  },
});


// ===============================
// Load Menu Items from Spring Boot
// ===============================

async function loadMenuItems() {
  try {
    const response = await fetch("http://localhost:8080/api/menu");

    if (!response.ok) {
      throw new Error("Menu API error: " + response.status);
    }

    const menuItems = await response.json();

    console.log("Menu items from backend:", menuItems);

    const menuContainer = document.querySelector(".menu-list");

    if (!menuContainer) {
      console.log("Menu container not found.");
      return;
    }

    menuContainer.innerHTML = "";

    menuItems.forEach((item) => {
      const menuItem = document.createElement("li");

      menuItem.classList.add("menu-item");

      menuItem.innerHTML = `
        <img
          src="${item.image}"
          alt="${item.name}"
          class="menu-image"
        >

        <div class="menu-details">
          <h3 class="name">${item.name}</h3>

          <p class="text">${item.description}</p>

          <span class="price">₹${item.price}</span>
        </div>
      `;

      menuContainer.appendChild(menuItem);
    });

  } catch (error) {
    console.error("Error loading menu:", error);
  }
}


// ===============================
// Contact Form - Backend Connection
// ===============================

document.addEventListener("DOMContentLoaded", () => {

  const contactForm = document.querySelector("#contactForm");

  if (!contactForm) {
    console.error("Contact form not found!");
    return;
  }

  contactForm.addEventListener("submit", async (event) => {

    event.preventDefault();

    const name = document.querySelector("#contactName").value.trim();
    const email = document.querySelector("#contactEmail").value.trim();
    const subject = document.querySelector("#contactSubject").value.trim();
    const message = document.querySelector("#contactMessage").value.trim();

    if (!name || !email || !subject || !message) {
      alert("Please fill all fields.");
      return;
    }

    const contactData = {
      name: name,
      email: email,
      subject: subject,
      message: message
    };

    console.log("Sending contact data:", contactData);

    try {

      const response = await fetch(
        "http://localhost:8080/api/contact",
        {
          method: "POST",
          headers: {
            "Content-Type": "application/json"
          },
          body: JSON.stringify(contactData)
        }
      );

      if (!response.ok) {
        throw new Error("Server error: " + response.status);
      }

      const result = await response.json();

      console.log("Message saved successfully:", result);

      alert("Thank you! Your message has been sent successfully.");

      // Clear form after successful submission
      contactForm.reset();

    } catch (error) {

      console.error("Contact form error:", error);

      alert(
        "Message was not sent. Please make sure the backend is running."
      );
    }

  });

});


// ===============================
// Start Menu Loading
// ===============================

document.addEventListener("DOMContentLoaded", loadMenuItems);

