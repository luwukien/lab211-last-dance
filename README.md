# Lab 211 — MVC Sample Code Projects

This repository collects small lab projects written following the Model-View-Controller (MVC) pattern. Use these samples to learn, experiment, and adapt for your own lab assignments. **Important:** always modify the code to meet *your* instructor's requirements before submitting.

## Projects
- [J1.L.P0021/StudentManagement](J1.L.P0021/StudentManagement/) — see [J1.L.P0021/StudentManagement/src/](J1.L.P0021/StudentManagement/src/)
- [J1.L.P0022/CandidateManagement](J1.L.P0022/CandidateManagement/) — see [J1.L.P0022/CandidateManagement/src/](J1.L.P0022/CandidateManagement/src/)
- [J1.S.P0009/Fibonacci](J1.S.P0009/Fibonacci/) — see [J1.S.P0009/Fibonacci/src/](J1.S.P0009/Fibonacci/src/)
- [J1.S.P0052/Geographic](J1.S.P0052/Geographic/) — see [J1.S.P0052/Geographic/src/](J1.S.P0052/Geographic/src/)
- [J1.S.P0070/Ebank](J1.S.P0070/Ebank/) — see [J1.S.P0070/Ebank/src/](J1.S.P0070/Ebank/src/)
- [J1.S.P0071/TaskManagement](J1.S.P0071/TaskManagement/) — see [J1.S.P0071/TaskManagement/src/](J1.S.P0071/TaskManagement/src/)
- [J1.S.P0083/MyStack](J1.S.P0083/MyStack/) — see [J1.S.P0083/MyStack/src/](J1.S.P0083/MyStack/src/)
- [J1.S.P0084/LargeNumber](J1.S.P0084/LargeNumber/) — see [J1.S.P0084/LargeNumber/src/](J1.S.P0084/LargeNumber/src/)

## Architecture (MVC)
1. Model (Business Logic & Entities)
- Pure Logic: No I/O operations (no Scanner, no print).

- Responsibilities: Manages data states and performs CRUD operations (Add/Update/Delete/Search).

- Validation: Handle data integrity here (e.g., checking for duplicate IDs).

2. View (User Interface)
- Strictly Presentation: No business logic or calculations allowed.

- Input Handling: All keyboard input must be validated (using loops/try-catch) before being sent to the Controller.

- Reusability: Write generic input methods to handle different data types (int, double, string).

3. Controller (The Orchestrator)
- Navigation: The only place where switch-case menu structures should exist.

- Communication: Acts as the bridge. It calls the View to get user data, passes it to the Model for processing, and then tells the View what to display.

- No Direct I/O: Do not use Scanner directly inside the Controller.

Overview data flow:

            +--------+
            |  Main  |
            +--------+
                 |
                 v
         +--------------+
         | Controller   |----\
         +--------------+     \
          /        |           \
         v         v            v
     +--------+ +-----------+ +----------+
     | View   | | Service   | |DataHelper|
     +--------+ +-----------+ +----------+

Flow:
Main -> Controller
Controller -> View (input/output)
Controller -> Service (business logic)
Service -> DataHelper (data access)
Controller -> View (display result)
            
## Notes on adapting for assignments
- Change names, structure, and implementation to match your assignment spec.
- Add or remove features per teacher requirements.
- Ensure proper input/output formatting and error handling expected by graders.
- Update tests or add new unit tests that reflect assignment criteria.

## License & Academic Integrity
These samples are provided for learning and quick reference. Do not submit unmodified code as your own. 

## Contributing
If you have improvements, open an issue or submit a PR.

## Disclaimer
Use these examples responsibly. The authors are not responsible for misuse.

## Finally

=))) Các bài code trên đây dù chưa hoàn chỉnh về comment, đặt tên biến dễ hiểu nhưng nó đủ để tham khảo về logic, luồng đi của dữ liệu như mô hình MVC, và đúng theo yêu cầu đề bài. Dù sao thì tôi suýt trượt môn LAB nếu không được anh/thầy Linh (LinhNDM3) tạo điều kiện cho, tôi đã PASSED ở tuần thứ 10. Lý do là do tôi quá tự tin vào bản thân mình đã code đúng, chuẩn chỉ. Nhưng thực tế thì tôi còn sai cả về logic, luồng đi dữ liệu như mô hình MVC. Buổi chiều hôm 26/03/2026 là một cú tát vào mặt tôi rằng tôi vẫn chỉ là một thằng sinh viên năm 2, chả là gì cả. Sau đó tôi nhận ra rằng tôi cần phải học hỏi nhiều từ mọi người, anh chị và các bạn. Chiều hôm 30/03/2026 lúc 4:00PM tôi đã review xong với anh Linh, và tôi đã PASSED. =))) hẹ hẹ may mắn rằng tôi đã nhận ra sớm, và đã không tự mãn về bản thân

30/03/2026 - 22:36PM