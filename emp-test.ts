empArray = [
    {
      "email": "admin@gmail.com",
      "password": "admin123",
      "name": "admin",
      "tel": "0900000000",
      "sex": "F",
      "birthday": "1998-10-01",
      "permissions": "1",
      "isQuit": "n",
      "isEdit": false
    },
    {
      "email": "normal@gmail.com",
      "password": "normal123",
      "name": "normal",
      "tel": "0900000001",
      "sex": "M",
      "birthday": "1999-10-23",
      "permissions": "2",
      "isQuit": "n", 
      "isEdit": false
    }
]

const empArray = [
  ...this.dataSource,
].map(v => ({...v, isEdit: false}));

onEdit(item: any) {
    debugger;
    this.empArray.forEach((element: any) => {
      element.isEdit = false;
    });
    item.isEdit = true;
  }
