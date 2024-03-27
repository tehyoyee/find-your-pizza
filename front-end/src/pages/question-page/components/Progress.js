import LinearProgress from '@mui/material/LinearProgress';

const Progress = ({ value }) => (
  <LinearProgress
    sx={{
      height: 20,
      borderRadius: 1,
      '&.MuiLinearProgress-colorPrimary': {
        backgroundColor: '#ffe8cc'
      },
      '& .MuiLinearProgress-bar': {
        borderRadius: 1,
        backgroundColor: '#ff922b'
      },
    }}
    style={{ zIndex: 10 }}
    value={value}
    variant="determinate"
  />
);

export default Progress;
