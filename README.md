# CSE 360 – Team 21 | TP2: Foundations Application

A JavaFX-based multi-user application developed for CSE 360 at Arizona State University.

## Team Members
- Manisha Chakrabarty
- *(Add remaining team members)*

## Project Overview

This project builds on TP1 to deliver a full-featured user management and student discussion platform. It includes role-based access control, account management, and a student post/reply system.

## Features

### TP1 (Carried Over)
- **Account Management** – Create accounts, set roles, update user info, delete users
- **Role-Based Access** – Admin, Student, Instructor, Staff, Reviewer roles
- **Admin Tools** – Reset passwords, manage roles (add/remove), first-admin setup
- **Input Validation** – Real-time username, email, and password validators with feedback

### TP2 (New)
- **Student Discussion Posts** – Students can create, view, and manage posts
- **Reply System** – Threaded replies on posts using `Post`, `Reply`, `PostList`, `ReplyList` entity classes
- **Post/Reply Testing** – Automated testing suite (`PostReplyTestingAutomation`)

## Project Structure

```
src/
├── applicationMain/        # Entry point (FoundationsMain.java)
├── database/               # In-memory database layer
├── entityClasses/          # Post, Reply, PostList, ReplyList
├── guiAdminHome/           # Admin home screen
├── guiAdminResetPassword/  # Admin password reset
├── guiAddRemoveRoles/      # Role management UI
├── guiNewAccount/          # New account creation
├── guiUserLogin/           # Login screen
├── guiUserUpdate/          # User profile update
├── guiMultipleRoleDispatch/# Role-selection dispatch for multi-role users
├── guiStudentPosts/        # Student posts UI (MVC)
├── guiStudentPostTests/    # Student post test suite
├── guiRole1/ guiRole2/     # Role-specific home screens
├── guiTools/               # Shared GUI utilities
├── validator/              # Password validator
├── Validators/             # Email & username validators
└── HW2/                    # Post/Reply automation tests
```

## Setup & Running

1. **Prerequisites:** Java 17+, JavaFX SDK, Eclipse IDE (or any Java IDE with JavaFX support)
2. Clone the repository
3. Open in Eclipse as an existing Java project
4. Configure JavaFX libraries in the build path
5. Run `applicationMain/FoundationsMain.java`

## Course Info

**Course:** CSE 360 – Introduction to Software Engineering
**Institution:** Arizona State University
**Semester:** Spring 2026
