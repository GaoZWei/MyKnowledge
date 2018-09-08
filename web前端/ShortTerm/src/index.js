import dva from 'dva';
import './index.css';

// 1. Initialize
//const app = dva();
const app = dva();
// 2. Plugins
// app.use({});

// 3. Model
// app.model(require('./models/example').default);
app.model(require('./models/sorts').default);
app.model(require('./models/shares').default);
app.model(require('./models/hots').default);
app.model(require('./models/collects').default);
app.model(require('./models/searchs').default);
app.model(require('./models/knowledges').default);
app.model(require('./models/login').default);
// 4. Router
app.router(require('./router').default);

// 5. Start
app.start('#root');
