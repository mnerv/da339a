# Lab 20

## Bank system

### TODO
  - [x] Edit customer (add accounts)
  - [x] Create new account
  - [x] Array of accounts for each customer
  - [x] Cleanup and restructure code

#### MISC
  - [ ] Transfer code to Marcus
  - [ ] Fix money display
  - [ ] Refactor display, create a buffer for displaying instead of printing immediately

## Post office

### TODO
  - [-] Remind Marcus to tell Pratchaya what to do
DONE: added customers, and menu navigation

To DO: create mail item thing and list them

### Main View

Letter:

```
┌─────────────────────────────────────┐
│                                     │
│  Firstname Lastname                 │
│  Addresss                           │
│  zip code                           │
│  City                               │
│  Country                            │
│                                     │
└─────────────────────────────────────┘
```

```
Main Menu

1. Customer -> Customer View
2. Mail -> Mail View
3. Exit
```

```
Customer View

1. List Customers
2. Add Customer
3. Go Back -> Main Menu
```

```
Mail View

1. List Mail Items
2. Add Mail -> Create a Mail
3. Go Back -> Main Menu
```


```
Create a Mail

<list_type>
Type: <input_here>

<list all customer>
Sender: <input_here>
Receiver: <input_here>

...

Mail View
```